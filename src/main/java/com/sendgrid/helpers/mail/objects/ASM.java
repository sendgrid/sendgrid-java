package com.sendgrid;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class ASM {
    public int group_id;
    public int[] groups_to_display;
    
    public void setGroupID(int group_id) {
        this.group_id = group_id;
    }
    
    public void setGroupsToDisplay(int[] GroupsToDisplay) {
        this.groups_to_display = Arrays.copyOf(GroupsToDisplay, GroupsToDisplay.length);
    }
}