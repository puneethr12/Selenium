package com.utility;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
@XmlRootElement(name="user")
public class User {

private String email;
private String password;
public String getEmail()
{
return email;
}
public String getPassword() {
return password;
}
    @XmlElement
public void setEmail(String email) {
this.email = email;
}
    @XmlElement
public void setPassword(String password) {
this.password = password;
}

}