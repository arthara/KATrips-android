package com.katripstask.katrips.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.katripstask.katrips.R;
import com.katripstask.katrips.model.Perjalanan;

import java.text.SimpleDateFormat;
import java.util.List;
public class PerjalananAdapter extends RecyclerView.Adapter<PerjalananAdapter.PerjalananViewHolder> {
    List<Perjalanan> listPerjalanan;
    Context context;
    private OnItemClickListener mListener;
    private String timePattern = "HH:mm:ss";
    private SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public PerjalananAdapter(Context context, List<Perjalanan> listPerjalanan) {
        this.listPerjalanan = listPerjalanan;
        this.context = context;
    }

    @NonNull
    @Override
    public PerjalananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.perjalanan_item, parent, false);
        return new PerjalananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerjalananViewHolder holder, final int position) {
        holder.tv_harga.setText("Rp. " + listPerjalanan.get(position).getHarga());
        holder.tv_stasiunAsal.setText(listPerjalanan.get(position).getLokasiBerangkat().getNama());
        holder.tv_stasiunTujuan.setText(listPerjalanan.get(position).getLokasiTiba().getNama());
        holder.tv_jamBerangkat.setText(listPerjalanan.get(position).getWaktuBerangkat(false));
        holder.tv_jamTiba.setText(listPerjalanan.get(position).getWaktuTiba(false));
        holder.tv_kelas.setText(listPerjalanan.get(position).getKelas());
        holder.tv_kereta.setText(listPerjalanan.get(position).getKereta());
        holder.tv_durasiPerjalanan.setText("2 Jam 3 Menit"); // Static, Dummy value
    }

    @Override
    public int getItemCount() {
        return listPerjalanan.size();
    }

    public class PerjalananViewHolder extends RecyclerView.ViewHolder {
        TextView tv_stasiunAsal, tv_jamBerangkat, tv_kereta;
        TextView tv_stasiunTujuan, tv_kelas, tv_durasiPerjalanan;
        TextView tv_jamTiba, tv_harga;
        CardView cardView;


        public PerjalananViewHolder(View view) {
            super(view);
            tv_stasiunAsal = view.findViewById(R.id.tv_perjalananItem_stasiunAsal);
            tv_stasiunTujuan = view.findViewById(R.id.tv_perjalananItem_stasiunTujuan);
            tv_jamBerangkat = view.findViewById(R.id.tv_perjalananItem_jamBerangkat);
            tv_jamTiba = view.findViewById(R.id.tv_perjalananItem_jamTiba);
            tv_kereta = view.findViewById(R.id.tv_perjalananItem_kereta);
            tv_kelas = view.findViewById(R.id.tv_perjalananItem_kelas);
            tv_durasiPerjalanan = view.findViewById(R.id.tv_perjalananItem_durasiPerjalanan);
            tv_harga = view.findViewById(R.id.tv_perjalananItem_harga);
            cardView = view.findViewById(R.id.cv_perjalananItem);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
