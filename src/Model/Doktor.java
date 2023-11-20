package Model;



public class Doktor extends Users{
    public Doktor(String tc_no, String password, String name, String type) {
        super(tc_no, password, name, type);
    }


    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getTc_no() {
        return super.getTc_no();
    }

    @Override
    public void setTc_no(String tc_no) {
        super.setTc_no(tc_no);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    public Doktor() {}
}
