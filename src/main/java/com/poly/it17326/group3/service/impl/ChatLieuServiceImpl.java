
package com.poly.it17326.group3.service.impl;

import com.poly.it17326.group3.domainmodels.ChatLieu;
import com.poly.it17326.group3.repository.ChatLieuRepository;
import com.poly.it17326.group3.service.ViewChatLieuService;
import java.util.List;


public class ChatLieuServiceImpl implements ViewChatLieuService{

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();
    
    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.getAll();
    }

    @Override
    public Boolean save(ChatLieu chatLieu) {
        return chatLieuRepository.add(chatLieu);
    }

    @Override
    public Boolean update(ChatLieu chatLieu) {
        return chatLieuRepository.update(chatLieu);
    }

    @Override
    public Boolean delete(ChatLieu chatLieu) {
        return chatLieuRepository.delete(chatLieu);
    }

    @Override
    public ChatLieu getOne(Integer ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
