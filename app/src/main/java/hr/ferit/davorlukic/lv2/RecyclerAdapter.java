package hr.ferit.davorlukic.lv2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private List<String> dataList = new ArrayList<>();
    private NameClickInterface clickInterface;

    public RecyclerAdapter(NameClickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new NameViewHolder(view, clickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data){
        dataList.clear();
        dataList.addAll(data);
        notifyDataSetChanged();
    }

    public void addNewItem(String name, int position) {
        if (position >= 0 && position <= dataList.size()){
            dataList.add(position, name);
            notifyItemInserted(position);
        }
    }

    public void removeItem(int position){
        if (position >= 0 && position < dataList.size()){
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
