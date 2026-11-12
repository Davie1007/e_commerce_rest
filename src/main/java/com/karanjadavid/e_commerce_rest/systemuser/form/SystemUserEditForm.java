package com.karanjadavid.e_commerce_rest.systemuser.form;

import com.karanjadavid.e_commerce_rest.lib.form.SessionUserIdForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemUserEditForm extends SessionUserIdForm {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
}
