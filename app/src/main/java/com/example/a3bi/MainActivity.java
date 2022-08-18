package com.example.a3bi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton data, espaco1, espaco2, n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, virgula, igual, nc;
    AppCompatImageButton buscar, gravar, comparar, nback;
    TextView anterior, resultado;
    int espaco = 1;
    int i;
    Float r;
    String imc1, data1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        SQLiteDatabase banco = openOrCreateDatabase("DB_IMC", MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS imcs(imc VARCHAR,data INT(8))");

        data = findViewById(R.id.data);
        anterior = findViewById(R.id.anterior);
        buscar = findViewById(R.id.buscar);
        espaco1 = findViewById(R.id.espaco1);
        espaco2 = findViewById(R.id.espaco2);
        gravar = findViewById(R.id.graavar);
        nback = findViewById(R.id.nback);
        resultado = findViewById(R.id.resualtado);
        comparar = findViewById(R.id.comparar);
        n0 = findViewById(R.id.n0);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        nc = findViewById(R.id.nc);
        igual = findViewById(R.id.igual);
        virgula = findViewById(R.id.virgula);


        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        n0.setOnClickListener(this);
        nc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espaco1.setText("");
                espaco2.setText("");
                resultado.setText("");
                resultado.setBackgroundResource(R.drawable.rosa);
                anterior.setText("");
                data.setText("");
                gravar.setBackgroundResource(R.drawable.curva);
            }
        });


        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!data.getText().toString().isEmpty() &&
                        !resultado.getText().toString().isEmpty()) {
                    gravar.setBackgroundResource(R.drawable.verde);


                    try {

                        String n = r.toString();
                        int d = Integer.parseInt(data.getText().toString());
                        System.out.println(d + "              " + n);


                        banco.execSQL("INSERT INTO imcs(imc,data) VALUES ((" + n + "),(" + d + "))");


                    } catch (Exception e) {
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAAAAAAA");
                        String n = r.toString();
                        int d = Integer.parseInt(data.getText().toString());
                    }


                } else {
                    resultado.setText("gere um resultado e insira uma data");
                }


            }
        });


        nback.setOnClickListener(this);
        virgula.setOnClickListener(this);
        igual.setOnClickListener(this);
        resultado.setOnClickListener(this);
        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravar.setBackgroundResource(R.drawable.curva);
                resultado.setBackgroundResource(R.drawable.rosa);

                try {
                    if (Float.parseFloat(anterior.getText().toString()) > r) {
                        resultado.setText("Seu IMC diminuiu: " + (Float.parseFloat(anterior.getText().toString()) - r));
                    } else if (Float.parseFloat(anterior.getText().toString()) == r) {
                        resultado.setText("Seu IMC não mudou");
                    } else {
                        resultado.setText("Seu IMC aumentou: " + (r - Float.parseFloat(anterior.getText().toString())));
                    }

                } catch (Exception e) {
                    resultado.setText("Busque um IMC anterior");

                }


            }
        });
        espaco1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espaco = 1;
                gravar.setBackgroundResource(R.drawable.curva);
            }
        });
        espaco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espaco = 2;
                gravar.setBackgroundResource(R.drawable.curva);
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String q[];
                    String x = "";
                    resultado.setText("");
                    resultado.setText(Float.parseFloat(espaco2.getText().toString()) /
                            (Float.parseFloat(espaco1.getText().toString()) *
                                    Float.parseFloat(espaco1.getText().toString())) + "");

                    q = resultado.getText().toString().split("");
                    for (int i = 0; i < 5; i++) {
                        resultado.setText(x += q[i]);
                    }

                    r = Float.parseFloat(resultado.getText().toString());


                    if (Float.parseFloat(resultado.getText().toString()) < 18.5) {
                        resultado.append(" Magreza");
                        resultado.setBackgroundResource(R.drawable.amarelo);
                    } else if (Float.parseFloat(resultado.getText().toString()) < 24.9) {
                        resultado.append(" Normal");
                        resultado.setBackgroundResource(R.drawable.verde);

                    } else if (Float.parseFloat(resultado.getText().toString()) < 29.9) {
                        resultado.append(" Sobrepeso");
                        resultado.setBackgroundResource(R.drawable.amarelo);
                    } else if (Float.parseFloat(resultado.getText().toString()) < 39.9) {
                        resultado.append(" Obesidade");
                        resultado.setBackgroundResource(R.drawable.laranja);
                    } else if (Float.parseFloat(resultado.getText().toString()) >= 40) {
                        resultado.append(" Obesidade grave");
                        resultado.setBackgroundResource(R.drawable.vermelho);
                    }

                }catch (Exception e){

                }



            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravar.setBackgroundResource(R.drawable.curva);
                espaco = 3;
                anterior.setText("");
            }
        });
        anterior.setOnClickListener(this);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gravar.setBackgroundResource(R.drawable.curva);

                try {

                    i = Integer.parseInt(data.getText().toString());

                    String consulta = "SELECT imc,data FROM imcs" +
                            " WHERE data LIKE (" + i + ")";

                    Cursor cursor = banco.rawQuery(consulta, null);
                    cursor.moveToFirst();

                    int iimc = cursor.getColumnIndex("imc");
                    int idata = cursor.getColumnIndex("data");


                    while (cursor != null) {

                        imc1 = cursor.getString(iimc);
                        data1 = cursor.getString(idata);
                        Log.i("RESULTADO", imc1 + " " + data1 + "PPPPPPPPPPPPPPPP");
                        System.out.println(imc1 + " " + data1);
                        anterior.setText(imc1);

                        cursor.moveToNext();
                    }


                } catch (Exception CursorIndexOutOfBoundsException) {
                    System.out.println("MMMMMMMMMMMMMMMMMMMMM");
                }


            }
        });


    }

    void adicionar(View a) {
        if (espaco == 2) {
            espaco2.setText(numero(a, espaco2.getText().toString()));
        } else if (espaco == 3) {
            anterior.setText("");
            data.setText(numero(a, data.getText().toString()));
        } else {
            espaco1.setText(numero(a, espaco1.getText().toString()));
        }


    }

    String numero(View a, String num) {

        String valor = num;
        gravar.setBackgroundResource(R.drawable.curva);


        switch (a.getId()) {


            case R.id.n0:
                valor += "0";
                break;

            case R.id.n1:
                valor += "1";
                break;

            case R.id.n2:
                valor += "2";
                break;

            case R.id.n3:
                valor += "3";
                break;

            case R.id.n4:
                valor += "4";
                break;

            case R.id.n5:
                valor += "5";
                break;

            case R.id.n6:
                valor += "6";
                break;

            case R.id.n7:
                valor += "7";
                break;

            case R.id.n8:
                valor += "8";
                break;

            case R.id.n9:
                valor += "9";
                break;

            case R.id.virgula:
                if (!valor.contains(".") &&
                        !valor.isEmpty()) {
                    valor += ".";
                }
                break;
            case R.id.nback:
                String[] z = valor.split("");
                valor = "";
                for (int i = 0; i < z.length - 1; ++i) {
                    valor += z[i];
                }
                break;


        }

        return valor;
    }


    @Override
    public void onClick(View v) {
        adicionar(v);


    }


}

