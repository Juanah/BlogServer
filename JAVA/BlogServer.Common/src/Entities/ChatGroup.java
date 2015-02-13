/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;

/**
 * Stellt eine Chatgruppe dar, die 'unbegrenzt' Nutzer aufnehmen kann
 * @author jonas
 */
public class ChatGroup extends BaseEntity {
    
    private String GroupName;
    
    private User Creator;
    
    private List<User> Member;

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public User getCreator() {
        return Creator;
    }

    public void setCreator(User Creator) {
        this.Creator = Creator;
    }

    public List<User> getMember() {
        return Member;
    }

    public void setMember(List<User> Member) {
        this.Member = Member;
    }
    
    
}
