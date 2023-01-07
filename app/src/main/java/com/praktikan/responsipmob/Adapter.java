package com.praktikan.responsipmob;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private ArrayList nama_id, nim_id, id;
    SQLiteOpenHelper dbcenter;

    public Adapter(Context context, ArrayList nama_id, ArrayList nim_id, ArrayList id) {
        this.context = context;
        this.nama_id = nama_id;
        this.nim_id = nim_id;
        this.id = id;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_mahasiswa,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_id.setText(String.valueOf(nama_id.get(position)));
        holder.nim_id.setText(String.valueOf(nim_id.get(position)));
        holder.id.setText(String.valueOf(id.get(position)));
    }

    @Override
    public int getItemCount() {
        return nama_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nama_id, nim_id, id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_id = itemView.findViewById(R.id.textname);
            nim_id = itemView.findViewById(R.id.textNIM);
            id = itemView.findViewById(R.id.set_id);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            String[] daftar = new String[0];
            final String selection = daftar[position];
            final CharSequence[] dialogitem = {"Update Data", "Hapus Data"};
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Pilihan");
            builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int item) {
                    switch (item) {
                        case 0:
                            Intent i = new Intent(view.getContext(), TampilanData.class);
                            i.putExtra("nama", selection);
                            view.getContext().startActivity(i);
                            break;
                        case 1:
                            Intent in = new Intent(view.getContext(), TampilanData.class);
                            in.putExtra("nama", selection);
                            view.getContext().startActivity(in);
                            break;
                        case 2:

                            SQLiteDatabase db = dbcenter.getWritableDatabase();
                            db.execSQL("DELETE FROM rm WHERE nama = '" + selection + "'");
                            Toast.makeText(view.getContext(), "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            builder.create().show();
        }
    }
// ...

}
