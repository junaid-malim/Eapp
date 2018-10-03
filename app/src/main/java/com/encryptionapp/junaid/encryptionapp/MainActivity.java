package com.encryptionapp.junaid.encryptionapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Crypto crypto=new Crypto(
            new SharedPrefsBackedKeyChain(MainActivity.this),
            new SystemNativeCryptoLibrary());
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        Entity entity = new Entity("password");
        byte[] ciphertext = new byte[0];
        try {
            ciphertext = crypto.encrypt(("data to encrypt").getBytes(),entity);
        } catch (KeyChainException e) {
            e.printStackTrace();
        } catch (CryptoInitializationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            byte[] plaintext = crypto.decrypt(ciphertext,entity);
            textView.setText(plaintext.toString());
        } catch (KeyChainException e) {
            e.printStackTrace();
        } catch (CryptoInitializationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }
