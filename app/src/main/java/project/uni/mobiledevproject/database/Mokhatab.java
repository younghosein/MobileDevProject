package project.uni.mobiledevproject.database;

public class Mokhatab {
    private int _id;
    private String _name;
    private String _phone;

    public Mokhatab(){}

    public Mokhatab(int id, String name, String phone){
        this._id = id;
        this._name = name;
        this._phone = phone;
    }

    public void SetID(int id){
        this._id = id;
    }
    public int GetID(){
        return this._id;
    }

    public void SetName(String name){
        this._name = name;
    }
    public String GetName(){
        return this._name;
    }

    public void SetPhone(String phone){
        this._phone = phone;
    }
    public String GetPhone(){
        return this._phone;
    }
}
