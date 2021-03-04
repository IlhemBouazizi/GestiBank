package com.sip.gestibank;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.sip.gestibank.models.Agent;

public class CustomListAdapter  extends BaseAdapter {
    private List<Agent> listData;
    private LayoutInflater layoutInflater;
    private Context context; public CustomListAdapter(Context aContext, List<Agent> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size(); }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) { convertView = layoutInflater.inflate(R.layout.agent_item_layout, null);
            holder = new ViewHolder();
            holder.agentNameView = (TextView) convertView.findViewById(R.id.textViewNom);
            holder.agentPrenomView = (TextView) convertView.findViewById(R.id.textViewPrenom);
            holder.agentMailView = (TextView) convertView.findViewById(R.id.textViewMail);
            holder.agentMatriculeView = (TextView) convertView.findViewById(R.id.textViewMatricule);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Agent agent = this.listData.get(position);
        holder.agentNameView.setText(agent.getName());
        holder.agentPrenomView.setText(agent.getPrenom());
        holder.agentMailView.setText(agent.getEmail());
        holder.agentMatriculeView.setText(agent.getMatricule());
        /*int imageId = this.getMipmapResIdByName(agent.getFlagName());
        holder.flagView.setImageResource(imageId);*/
        return convertView;
    }
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID; }

static class ViewHolder {
        TextView agentNameView; TextView agentPrenomView; TextView agentMailView; TextView agentMatriculeView;
}
}