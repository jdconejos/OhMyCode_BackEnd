package com.ohmycode.rest.DTOs;

//Clase que aporta la contraseña del usuario
public class DTOAuthUser extends DTOUser{
    private String password;

    public DTOAuthUser() {
        super();
    }

    public DTOAuthUser(Long id, String name, String username, DTOAddress address, String password) {
        super(id, name, username, address);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
