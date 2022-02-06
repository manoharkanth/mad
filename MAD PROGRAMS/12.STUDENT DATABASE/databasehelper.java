import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper (Context context) {
        super(context, "Student.db", null, 1);
    }
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LAB ( PATID integer PRIMARY KEY AUTOINCREMENT, USN TEXT, STUDENT_NAME TEXT, SEMESTER TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LAB ");
        onCreate(sqLiteDatabase);
    }
    public boolean insert (String usn, String name, String sem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("USN", usn);
        cv.put("STUDENT_NAME", name);
        cv.put("SEMESTER", sem);
        long status = db.insert("LAB",null,cv);
        if (status == -1)
            return false;
        else
            return true;
    }
    public Cursor select() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM LAB", null);
        return cr;
    }
}