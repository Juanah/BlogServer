package de.juanah.lenasblogwebservice.DTO.Communication.Processor;

import com.google.gson.Gson;

import de.juanah.lenasblogdataaccess.Entities.User;
import de.juanah.lenasblogwebservice.DTO.Communication.Messages.User.BoolResponseMessage;
import de.juanah.lenasblogwebservice.DTO.Communication.Messages.User.UserAdd;
import de.juanah.lenasblogwebservice.DTO.Communication.WCFHelper;
import de.juanah.lenasblogwebservice.DTO.UserDTO;

/**
 * Created by jonas on 15.02.15.
 */
public class UserProcessor {

    private static Gson gson = new Gson();

    private WCFHelper wcfHelper = new WCFHelper();

    public boolean AddUser(User user)
    {
        UserDTO dto = new UserDTO();
        dto.Authentification = user.getAuthentification();
        dto.ImageBytes = null;
        dto.Username = user.getUsername();

        UserAdd addMessage = new UserAdd();
        addMessage.Creator = dto;
        addMessage.ToAdd = dto;

        String jsonObject = gson.toJson(addMessage);


        String response = wcfHelper.Request("user_add/" + jsonObject);

        BoolResponseMessage responseMessage = gson.fromJson(response,BoolResponseMessage.class);
        return responseMessage.Success;
    }


}
