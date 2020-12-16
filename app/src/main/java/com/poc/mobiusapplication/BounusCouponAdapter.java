package com.poc.mobiusapplication;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.poc.mobiusapplication.databinding.CustomLayoutBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BounusCouponAdapter extends RecyclerView.Adapter<BounusCouponAdapter.ViewHolder> {

    private List<BonusCouponModel> dataList;
    private Context context;
    CustomLayoutBinding itemRowDataBinding;
    int nFlag = 0;

    public BounusCouponAdapter(List<BonusCouponModel> dataList,Context context){
        this.context = context;
        this.dataList = dataList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;

        ViewHolder(CustomLayoutBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            itemRowDataBinding = itemRowBinding;

            ///txtTitle = mView.findViewById(R.id.title);
        }
    }

    @Override
    public BounusCouponAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.custom_layout, parent, false);
        CustomLayoutBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.custom_layout, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        List<Double> sortedMinSlab = new ArrayList<>();
        List<Double> sortedMaxPercent = new ArrayList<>();
        List<Double> sortedMaxSlab = new ArrayList<>();
        //holder.txtTitle.setText(dataList.get(position).getTitle());
        itemRowDataBinding.code.setText(dataList.get(position).getCode().toUpperCase());
        itemRowDataBinding.ribbonMsg.setText(dataList.get(position).getRibbonMsg());
        itemRowDataBinding.validUntil.setText("Valid till\t"+ConvertDate(dataList.get(position).getValidUntil()));
        itemRowDataBinding.wageNumDenominator.setText("For every \u20B9"+dataList.get(position).getWagerToReleaseRatioNumerator()+"\tbet \u20B9"+dataList.get(position).getWagerToReleaseRatioDenominator()+"\twill be released from the bonus amount");

        itemRowDataBinding.wageBonusExpiry.setText("Bonus expiry\t"+ dataList.get(position).getWagerBonusExpiry() +"\tdays from the issue");

        List<BonusCouponModel.Slab> slabsList = dataList.get(position).getSlabs();
        int slabSize = slabsList.size();
        itemRowDataBinding.llSlabs.setRowCount(6);
        itemRowDataBinding.llSlabs.setColumnCount(3);
        for (int i = 0; i < slabSize; i++) {
            for (int j = 0; j < 3; j++) {
                TextView textView = new TextView(context);
                textView.setTextColor(context.getResources().getColorStateList(R.color.black));
                //Add a drawable left icon to the TextView
                //The following line must be, otherwise the icon will not be displayed.)
                //textView.setPadding(TO.dp2px(context, 15f), 0, 0, 0);
                textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

                GridLayout.Spec rowSpec = null;
                GridLayout.Spec columnSpec = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    rowSpec = GridLayout.spec(i, 1.0f);
                    columnSpec = GridLayout.spec(j, 1.0f);
                }
                GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
                //Left to the left, right to the right, center to the middle, the default is centered
                sortedMinSlab.add(slabsList.get(i).getMin());
                sortedMaxPercent.add(slabsList.get(i).getOtcPercent() + slabsList.get(i).getWageredPercent());
                sortedMaxSlab.add(slabsList.get(i).getOtcMax() + slabsList.get(i).getWageredMax());

                switch (j) {
                    case 0:
                        params.setGravity(Gravity.LEFT);
                        if(i==0)
                            textView.setText("\u003C "+String.valueOf(Integer.valueOf(slabsList.get(i).getMin().intValue())));
                        else if(i==1)
                            textView.setText("\u2265"+String.valueOf(Integer.valueOf(slabsList.get(i).getMin().intValue())) + " \n &" + " \u003C"+ String.valueOf(Integer.valueOf(slabsList.get(i).getMax().intValue())));
                        else if(i==2)
                            textView.setText("\u2265 "+String.valueOf(Integer.valueOf(slabsList.get(i).getMax().intValue())));
                        break;
                    case 1:
                        params.setGravity(Gravity.CENTER);
                        textView.setText(String.valueOf(Integer.valueOf((slabsList.get(i).getWageredPercent().intValue())))+"%"+"(Max. \u20B9"+Integer.valueOf((slabsList.get(i).getWageredMax().intValue()))+")");
                        break;
                    case 2:
                        params.setGravity(Gravity.RIGHT);
                        textView.setText(String.valueOf(Integer.valueOf((slabsList.get(i).getOtcPercent().intValue())))+"%"+"(Max. \u20B9"+Integer.valueOf((slabsList.get(i).getOtcMax().intValue()))+")");
                        break;
                    default:
                        params.setGravity(Gravity.CENTER);
                        break;
                }
                //params.bottomMargin = TO.dp2px(mContext, 11.5f);

                // Control the height and width of the TextView
                //params.height = TO.dp2px(mContext, 25.0f);
                //params.width = TO.dp2px(mContext, 90.0f);
                itemRowDataBinding.llSlabs.addView(textView, params);
            }
        }
        Collections.sort(sortedMinSlab);
        itemRowDataBinding.slabMin.setText("\u20B9"+String.valueOf(Integer.valueOf(sortedMinSlab.get(0).intValue())));
        itemRowDataBinding.slabMax.setText("Upto\t\u20B9"+String.valueOf(Integer.valueOf(Collections.max(sortedMaxSlab).intValue())));
        itemRowDataBinding.slabPercentage.setText("Get "+String.valueOf(Integer.valueOf(Collections.max(sortedMaxPercent).intValue()))+"%");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    
    public String ConvertDate(String strDate){
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat formatterOut = new SimpleDateFormat("dd MMM,yyyy HH:mm aa");
        try {
            date = format.parse(strDate);
            System.out.println(date);
            System.out.println(formatterOut.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatterOut.format(date);
    }
}