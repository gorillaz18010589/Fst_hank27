package tw.brad.apps.brad27;
//sqllite資料庫
//輔助程式
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper  extends SQLiteOpenHelper {//繼承SQL實做兩個介面,建構式要處理
    private  final  String createTable =
            "CREATE TABLE cust (id INTEGER primary key autoincrement,"+
            "cname TEXT, birthday DATE)"; //宣告創表
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {//(1.活在這個activity,2.庫名3.游標指引4.版本數)
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);//執行寫好的表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//上傳版本更新

    }
}
