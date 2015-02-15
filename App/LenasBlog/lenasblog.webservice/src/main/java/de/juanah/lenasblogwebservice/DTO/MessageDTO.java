package de.juanah.lenasblogwebservice.DTO;

/**
 * Created by jonas on 15.02.15.
 */
public class MessageDTO {

    public UserDTO Creator;
    public UserDTO Receiver;

    public String Content;

    public byte[] ImageBytes;
}
