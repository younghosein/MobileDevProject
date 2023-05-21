package project.uni.mobiledevproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private String strTblMk = "Tbl_Mokhatab";

    public DBHandler(Context context) {
        super(context, "DbMokhataban", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "CREATE TABLE "+ strTblMk +" (" +
                "ID Primary Key AutoIncrement," +
                "Name Text," +
                "Phone Text)";
        //***
        db.execSQL(strSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ strTblMk);
        //***
        onCreate(db);
    }

    //CRUD = Create, Read, Update, Delete

    public void AddMokhatab1(Mokhatab model){
        SQLiteDatabase db = this.getWritableDatabase();
        //***
        ContentValues myValue = new ContentValues();
        myValue.put("Name", model.GetName());
        myValue.put("Phone", model.GetPhone());
        db.insert(strTblMk, null, myValue);
        db.close();
    }

    public Mokhatab GetMokhatab(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor myCur = db.query(strTblMk, new String[]{"ID", "Name", "Phone"},
                "ID = ?", new String[]{id}, null, null, null);
        if(myCur != null)
        {

            myCur.moveToFirst();
            Mokhatab model = new Mokhatab(Integer.parseInt(myCur.getString(0)),
                    myCur.getString(1),
                    myCur.getString(2));
            return model;
        }
        db.close();
        //***
        return null;
    }

    public List<Mokhatab> GetAllMokhatab(){
        List<Mokhatab> _list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        //***
        String strSql = "SELECT * FROM "+ strTblMk;
        Cursor myCur = db.rawQuery(strSql, null);
        if(myCur.moveToFirst()){
            do{
                Mokhatab model = new Mokhatab(Integer.parseInt(myCur.getString(0)),
                        myCur.getString(1),
                        myCur.getString(2));
                _list.add(model);
            }while (myCur.moveToNext());
            //***
            return _list;
        }
        return null;
    }

    public List<Mokhatab> SearchMokhatab(String search){
        List<Mokhatab> _list = new ArrayList<Mokhatab>();
        SQLiteDatabase db = this.getReadableDatabase();
        //***
        String strSql = "SELECT * FROM "+ strTblMk +
                " WHERE (Name LIKE '%"+ search +"%') OR (Phone = '%"+ search +"%') ";
        Cursor myCur = db.rawQuery(strSql, null);
        if(myCur.moveToFirst()){
            do{
                Mokhatab model = new Mokhatab(Integer.parseInt(myCur.getString(0)),
                        myCur.getString(1),
                        myCur.getString(2));
                _list.add(model);
            }while (myCur.moveToNext());
            //***
            return _list;
        }
        return null;
    }

    public void AddMokhatab2(Mokhatab model){
        SQLiteDatabase db = this.getWritableDatabase();
        String strSql = "INSERT INTO "+ strTblMk +" (Name, Phone) " +
                " Values ("+ model.GetName() +", "+ model.GetPhone() +")";
        db.execSQL(strSql);
        db.close();
    }

    public void UpdateMokhatab1(Mokhatab model, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues myValue = new ContentValues();
        myValue.put("Name", model.GetName());
        myValue.put("Phone", model.GetPhone());
        db.update(strTblMk, myValue, "ID = ?", new String[]{ id});
        db.close();
    }

    public void UpdateMokhatab2(Mokhatab model, String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String strSql ="UPDATE "+strTblMk +" SET "+
                "Name = '"+ model.GetName() + "', "+
                "Phone = '"+ model.GetPhone() + "' "+
                "WHERE (ID = "+ id + ")";
        //***
        db.execSQL(strSql);
        db.close();
    }

    public void DeleteMokhatab1(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(strTblMk, "ID = ?", new String[]{ id});
        db.close();
    }

    public void DeleteMokhatab2(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+strTblMk + " WHERE (ID = "+ id + ")");
        db.close();
    }
}
