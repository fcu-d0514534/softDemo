package com.shang.softdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    static String[] url={"http://myweb.fcu.edu.tw/~d0591821/map/","http://myweb.fcu.edu.tw/~d0512808/map/"
            ,"http://myweb.fcu.edu.tw/~d0514195/health/health.html","http://www.scu.edu.tw/health/Work/form1.php"};
    static String[] problem={"抽籤問題","搜尋問題","健康管理參照問題","卡路里計算問題","聯絡我們問題"};
    static String[] content={"選擇類別,位置,距離按下確定","輸入關鍵字然後跳到google map","自己看圖","使用清單選擇計算卡路里","使用Message來回報問題"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==4){
                    String[] to={"D0514534@gmail.com"};
                    String[] cc = {"D0514534@gmail.com"};
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL,to);
                    intent.putExtra(Intent.EXTRA_CC,cc);
                    intent.putExtra(Intent.EXTRA_SUBJECT,"問題回報");
                    intent.putExtra(Intent.EXTRA_TEXT,"內容");
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                }else if(position==5){
                    showProblem();
                }else{
                    Intent intent=new Intent(MainActivity.this,WebActivity.class);
                    intent.putExtra("URL",getURL(position));
                    startActivity(intent);
                }
            }
        });
        listView.setAdapter(new MyAdapter(MainActivity.this));
    }

    public static String getURL(int position){
        return url[position];
    }

    public static String getContent(int position){
        return content[position];
    }

    public void showProblem(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("常見問題")
                .setItems(problem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("內容")
                                .setMessage(getContent(which))
                                .show();
                    }
                })
                .show();
    }


}
