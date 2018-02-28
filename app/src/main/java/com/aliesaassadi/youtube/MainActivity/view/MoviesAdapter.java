package com.aliesaassadi.youtube.MainActivity.view;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.aliesaassadi.youtube.MainActivity.models.model.Video;
import com.aliesaassadi.youtube.MainActivity.models.model.Playlists;
import com.aliesaassadi.youtube.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali Esa Assadi
 */

public class MoviesAdapter extends ExpandableRecyclerViewAdapter<MoviesAdapter.TitleViewHolder,MoviesAdapter.ItemViewHolder> implements View.OnClickListener {


    private OnMoviesAdapter mListener;

    public interface OnMoviesAdapter{
        void onMoviesAdapterClicked(String link);
    }

    public MoviesAdapter(List<? extends ExpandableGroup> groups, OnMoviesAdapter listener) {
        super(groups);
        mListener = listener;
    }


    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_playlist, parent, false);
        return new TitleViewHolder(view);
    }

    @Override
    public ItemViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ItemViewHolder holder, int flatPosition,
                                      ExpandableGroup group, final int childIndex) {

        Video video = ((Playlists) group).getItems().get(childIndex);

        holder.setTitle(video.getTitle());
        holder.setImageView(video.getThumb());

        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(video.getLink());
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        Playlists playlists = (Playlists) group;
        holder.setGenreTitle(playlists);
    }

    public static class TitleViewHolder extends GroupViewHolder {

        @BindView(R.id.title)  TextView titleName;
        @BindView(R.id.arrow)  ImageView arrow;

        private TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        private void setGenreTitle(Playlists playlists) {
            titleName.setText(playlists.getTitle());
        }

        @Override
        public void expand() {
            animateExpand();
            itemView.setBackgroundResource(R.color.gray_on_click);
        }

        @Override
        public void collapse() {
            animateCollapse();
            itemView.setBackgroundResource(0);
        }

        private void animateExpand() {
            RotateAnimation rotate = new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }
    }

    public static class ItemViewHolder extends ChildViewHolder {

        @BindView(R.id.title) TextView title;
        @BindView(R.id.imageView) SimpleDraweeView imageView;

        private ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setTitle(String name) {
            title.setText(name);
        }

        private void setImageView(String url) {
            String urlWithOutSpaces = url.replace(" ","");
            imageView.setImageURI(Uri.parse(urlWithOutSpaces));
        }
    }

    @Override
    public void onClick(View view) {
        String link = (String) view.getTag();
        mListener.onMoviesAdapterClicked(link);
    }
}
