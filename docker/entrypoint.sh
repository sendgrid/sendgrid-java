#! /bin/bash
clear

# check for + link mounted libraries:
if [ -d /mnt/sendgrid-java ]
then
	rm /root/sendgrid
	ln -s /mnt/sendgrid-java/sendgrid
	echo "Linked mounted sendgrid-java's code to /root/sendgrid"
fi

SENDGRID_JAVA_VERSION="1.0.0"
echo "Welcome to sendgrid-java docker v${SENDGRID_JAVA_VERSION}."
echo

if [ "$1" != "--no-mock" ]
then
	echo "Starting Prism in mock mode. Calls made to Prism will not actually send emails."
	echo "Disable this by running this container with --no-mock."
	prism run --mock --spec $OAI_SPEC_URL 2> /dev/null &
else
	echo "Starting Prism in live (--no-mock) mode. Calls made to Prism will send emails."
	prism run --spec $OAI_SPEC_URL 2> /dev/null  &
fi
echo "To use Prism, make API calls to localhost:4010. For example,"
echo "    sg = sendgrid.SendGridAPIClient("
echo "        host='http://localhost:4010/',"
echo "        api_key=os.environ.get('SENDGRID_API_KEY_CAMPAIGNS'))"
echo "To stop Prism, run \"kill $!\" from the shell."

bash