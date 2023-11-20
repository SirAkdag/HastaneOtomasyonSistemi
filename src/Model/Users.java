package Model;

public class Users {
    private int id;
    String tc_no, password, name, type;

    public Users(String tc_no, String password, String name, String type) {
        this.id = id;
        this.tc_no = tc_no;
        this.password = password;
        this.name = name;
        this.type = type;
    }
    public Users(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
