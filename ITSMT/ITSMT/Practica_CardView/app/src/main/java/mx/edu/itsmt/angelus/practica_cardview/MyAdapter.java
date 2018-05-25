package mx.edu.itsmt.angelus.practica_cardview;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;

    public MyAdapter(List<Movie> movies, int layout, OnItemClickListener itemClickListener) {
        this.movies = movies;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //se infla el layout y se le pasa al constructor del viewholder, donde
        //se manejara toda la logica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     holder.bind(movies.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        //elementos de UI a rellenar
        public TextView textViewName;
        public ImageView poster;

        public ViewHolder(View itemView) {
           //recibe la view completa y la pasa al constructor padre y enlaza referencias con UI
            //con las propiedades viewholder declaradas arriba
            super(itemView);
            this.textViewName=(TextView) itemView.findViewById(R.id.textviewtitulo);
            this.poster=(ImageView) itemView.findViewById(R.id.imageviewposter);
        }
        public void bind(final Movie movie,final OnItemClickListener listener){
           //se procesan los datos a renderizar
            this.textViewName.setText(movie.getName());
            this.poster.setImageResource(movie.getPoster());
            Picasso.get().load(movie.getPoster()).fit().into(poster);
            //definimos que por cada elemento del reclycler, se tiene un clik listener
            //que se comporta de la siguiente forma ...
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(movie,getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(Movie movie, int position);
    }

}

