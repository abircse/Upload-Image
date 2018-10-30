package com.studioabir.imageupload.volleyimageupload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    ImageView USERIMAGE;
    EditText CAPTION;
    Button SELECTIMAGE, UPLOADIMAGE;
    final int REQUEST_CODE = 1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USERIMAGE = findViewById(R.id.myimage);
        CAPTION = findViewById(R.id.imagecaption);
        SELECTIMAGE = findViewById(R.id.chooseimage);
        UPLOADIMAGE = findViewById(R.id.upimag);

       SELECTIMAGE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               selectImage();
           }
       });


        UPLOADIMAGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Upload();
            }
        });

    }


    private void Upload() {

        String url = "http://192.168.43.109/uploadimage/upload.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    String serverresult = jsonObject.getString("response");
                    Toast.makeText(MainActivity.this, serverresult, Toast.LENGTH_LONG).show();
                    USERIMAGE.setImageResource(0);
                    USERIMAGE.setVisibility(View.GONE);
                    CAPTION.setText("");
                    CAPTION.setVisibility(View.GONE);


                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_LONG).show();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> map = new HashMap<>();
                map.put("image",ImageToString(bitmap));
                map.put("caption",CAPTION.getText().toString().trim());
                return map;
            }
        };

        com.studioabir.imageupload.volleyimageupload.utils.AppController.getInstance().addToRequestQueue(stringRequest);

    }


    //-----This method is to convert imagebitmap into string----//
    private String ImageToString(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgbyte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbyte,Base64.DEFAULT);
    }

    //-----1. This method is for select image from gallery or storage-----//
    private void selectImage()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,REQUEST_CODE);
    }

    ///------2. Onactivity result for maintain image & perform bitmap operation----//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data!= null)
        {
            Uri myfilepath = data.getData();
            try
            {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),myfilepath);
                USERIMAGE.setImageBitmap(bitmap);
                USERIMAGE.setVisibility(View.VISIBLE);
                CAPTION.setVisibility(View.VISIBLE);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
