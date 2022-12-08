package com.poly.it17326.group3.service;

import com.poly.it17326.group3.domainmodels.ChatLieu;
import java.util.List;

public interface ViewChatLieuService {

    List<ChatLieu> getAll();

    Boolean save(ChatLieu chatLieu);

    Boolean update(ChatLieu chatLieu);

    Boolean delete(ChatLieu chatLieu);

    ChatLieu getOne(Integer ID);
}
