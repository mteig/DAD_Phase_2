package com.dad.registration.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dad.R;
import com.dad.home.BaseFragment;
import com.dad.registration.activity.MainActivity;

/**
 * RegistartionFragment : user can register or login
 */
public class RegistartionFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration_new, container, false);
    }

    @Override
    public void initView(View view) {
        final TextView tvCreateAccount = (TextView) view.findViewById(R.id.fragment_registration_tv_create_account);
        final TextView tvLoginToYourAccount = (TextView) view.findViewById(R.id.fragment_registration_tv_login_to_your_account);
        final TextView tvShowEula = (TextView) view.findViewById(R.id.fragment_registration_tv_show_eula);
        tvCreateAccount.setOnClickListener(this);
        tvLoginToYourAccount.setOnClickListener(this);
        tvShowEula.setOnClickListener(this);
    }

    @Override
    public void trackScreen() {
    }

    @Override
    public void initActionBar() {
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.fragment_registration_tv_create_account:
                ((MainActivity) getActivity()).addFragment(new CreateAccountFragment(), RegistartionFragment.this);
                break;
            case R.id.fragment_registration_tv_login_to_your_account:
                ((MainActivity) getActivity()).addFragment(new LoginToYourAccountFragment(), RegistartionFragment.this);
                break;
            case R.id.fragment_registration_tv_show_eula:
//                final Dialog dialog = new Dialog(getActivity());
//                dialog.setContentView(R.layout.fragment_terms_and_condition);
//                dialog.findViewById(R.id.fragment_terms_and_condition_tv_cancel).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();

                final FragmentManager fm = getFragmentManager();
                final TermAndConditionFragment termAndConditionFragment = new TermAndConditionFragment();
                termAndConditionFragment.show(fm, RegistartionFragment.class.getSimpleName());
                break;
        }
    }


}