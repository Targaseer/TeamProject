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

        /*
        //Добавляю добавление тегов
        Tag tag1=new Tag();
        tag1.setName("tiktok");
        tag1.setChat(chat);
        tag1.setColor("#03fcdb");
        Tag tag2=new Tag();
        tag2.setName("instagram");
        tag2.setChat(chat);
        tag2.setColor("#f542ef");
        Tag tag3=new Tag();
        tag3.setName("vkontakte");
        tag3.setChat(chat);
        tag3.setColor("#fcba03");
        Tag tag4=new Tag();
        tag4.setName("spam");
        tag4.setChat(chat);
        tag4.setColor("#ffffff");
        tagRepo.save(tag1);
        tagRepo.save(tag2);
        tagRepo.save(tag3);
        tagRepo.save(tag4);


        Message msg=new Message();
        msg.setChat(chat);
        msg.setUser(u1);
        msg.setText("Hello from user1. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
        GregorianCalendar cl=new GregorianCalendar(2021,6,23,16,0);
        msg.setCreate_date(cl.getTime());

        messageRepo.save(msg);

        Message msg1=new Message();
        msg1.setChat(chat);
        msg1.setUser(u2);
        GregorianCalendar cl1=new GregorianCalendar(2021,6,23,17,0);
        msg1.setCreate_date(cl1.getTime());
        msg1.setText("Hello from user2");
        messageRepo.save(msg1);


        Message_Tag mt=new Message_Tag();
        mt.setMessage(msg);
        mt.setTag(tag1);
        messageTagRepo.save(mt);

        Message_Tag mt1=new Message_Tag();
        mt1.setMessage(msg);
        mt1.setTag(tag2);
        messageTagRepo.save(mt1);

        Message_Tag mt2=new Message_Tag();
        mt2.setMessage(msg);
        mt2.setTag(tag3);
        messageTagRepo.save(mt2);*/
    }
}
