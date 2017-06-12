package singlepageapp.mohanty.dinesh.com.languagetraining;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * We created this custom array adapter so that we can add one or more item in the list view or it can show the word objects
 * we do this by overriding getView method of array adapter
 */
public class WordAdapter extends ArrayAdapter<Word>{

    private int color;

    public WordAdapter(Activity context ,ArrayList<Word> words , int color)
    {
        super(context, 0, words);
        this.color = color;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_layout, parent, false);
        }

        Word word = getItem(position);
        TextView textView = (TextView) listItemView.findViewById(R.id.text_mewaki);
        textView.setText(word.getMewaki());
        TextView textView1 = (TextView)listItemView.findViewById(R.id.text_english);
        textView1.setText(word.getEnglish());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(word.hasImage()) {

            imageView.setImageResource(word.getId());
        }else
        {
            imageView.setVisibility(View.GONE);
        }
        LinearLayout linearLayout = (LinearLayout)listItemView.findViewById(R.id.linear_color);
        linearLayout.setBackgroundResource(color);






        return listItemView;
    }
}
