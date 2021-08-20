package com.example.TeamProject;

import com.example.TeamProject.entities.*;
import com.example.TeamProject.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    @Autowired
    private ChatRepository chatRepo;

    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private MessageTagRepository messageTagRepo;

    @Autowired
    private TagRepository tagRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserChatRepository userChatRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRoleRepository userRoleRepo;

    @PostConstruct
    public void loadData(){
        Chat chat=new Chat();
        chat.setTitle("chat1");
        chat.setDescription("d1");
        chatRepo.save(chat);

        Chat chat2=new Chat();
        chat2.setTitle("chat2");
        chat2.setDescription("d2");
        chatRepo.save(chat2);

        Role r1=new Role("User");
        Role r2=new Role("Admin");
        roleRepo.save(r1);
        roleRepo.save(r2);

        User u1=new User();
        User u2=new User();
        u1.setUsername("user1");
        u1.setPhoneNum("+12345678901");
        u1.setPassword(passwordEncoder.encode("admin"));
        u2.setUsername("user2");
        u2.setPhoneNum("+98765432109");
        u2.setPassword(passwordEncoder.encode("user"));
        userRepo.save(u1);
        userRepo.save(u2);

        User_Roles ur=new User_Roles();
        ur.setUser(u1);
        ur.setRole(roleRepo.findRoleByName("Admin"));
        userRoleRepo.save(ur);

        User_Roles ur1=new User_Roles();
        ur1.setUser(u2);
        ur1.setRole(roleRepo.findRoleByName("User"));
        userRoleRepo.save(ur1);

        User_Chat uc=new User_Chat();

        uc.setUser(u1);
        uc.setChat(chat);
        userChatRepo.save(uc);

        User_Chat uc1=new User_Chat();
        uc1.setUser(u2);
        uc1.setChat(chat);
        userChatRepo.save(uc1);
        
        Tag tag0=new Tag();
        tag0.setName("Main");
        tag0.setChat(chat);
        tagRepo.save(tag0);
    }
}
