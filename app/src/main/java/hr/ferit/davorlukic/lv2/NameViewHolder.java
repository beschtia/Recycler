package hr.ferit.davorlukic.lv2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView tvName;
    private ImageView ivRemove;
    private NameClickInterface clickInterface;

    public NameViewHolder(View itemView, NameClickInterface clickInterface) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        ivRemove = itemView.findViewById(R.id.ivRemove);
        this.clickInterface = clickInterface;
        ivRemove.setOnClickListener(this);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View view) {
        clickInterface.onNameClicked(getAdapterPosition());
    }
}
