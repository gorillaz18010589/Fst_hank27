package tw.brad.apps.brad27;
//在系統上面有哪些資料庫,聯絡不,相簿,先玩自訂的,在玩共用得
//資料庫放在內存空間
//https://en.softonic.com/download/sqlitemanager/windows/post-download?ex=BB-1006.3瀏覽器外掛,下載
//select,where,group by,having ,order by .limit
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //拿到database的物件實體
        myDBHelper = new MyDBHelper(this, "brad", null, 1);//呼叫寫好的資料庫(1.這個頁面2.庫名3.游標,4.版本 )
        database = myDBHelper.getReadableDatabase(); //從這個寫好酷表取得物件實體

    }
        //增
    public void insert(View view) {
        //舊的新增方式容易被名馬攻擊
        String sql = "INSERT INTO cust (cname,birthday) VALUES ('Brad', '1999-01-02')";
        database.execSQL(sql);


        ContentValues values = new ContentValues();
        values.put("cname","Eric");
        values.put("birthday","1999-02-03");
        database.insert("cust",null,values);

        query(null);
    }
        //刪
    public void delete(View view) {

    }
        //修
    public void update(View view) {

    }
        //查
    public void query(View view) {
        //String sql = "SELECT * FROM cust"; 原始寫法
        Cursor cursor = database.query("cust", null, null,null,
                null,null,null); //(庫表,select,where,group by,having ,order by .limit,)取得查詢游標
        if (cursor != null){ //如果資料庫沒空
            while (cursor.moveToNext()){//下一筆游標資料
                String id = cursor.getString(cursor.getColumnIndex("id")); //取得id列的資料庫欄位存到id
                String cname = cursor.getString(cursor.getColumnIndex("cname"));
                String birthday = cursor.getString(cursor.getColumnIndex("birthday"));
                Log.v("brad", id + ":" + cname + ":" + birthday);
            }
        }


    }
}