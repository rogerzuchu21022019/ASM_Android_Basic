package com.example.asm.fragment.fmLogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.asm.R;
import com.example.asm.databinding.FragmentBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.FirebaseAuth;

public class BottomSheetFM extends BottomSheetDialogFragment implements View.OnClickListener {
    FragmentBottomSheetBinding fmBottomSheetBinding;
NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fmBottomSheetBinding = FragmentBottomSheetBinding.inflate(getLayoutInflater());
        initButton();
        initNavController();
        return fmBottomSheetBinding.getRoot();
    }

    private void initNavController() {
        navController = Navigation.findNavController(requireActivity(),R.id.fmCVHost);
    }

    private void initButton() {
        fmBottomSheetBinding.acbSignOutNo.setOnClickListener(this);
        fmBottomSheetBinding.acbSignOutYes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.acbSignOutYes) {
            Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show();
            requireActivity().finish();
            FirebaseAuth.getInstance().signOut();
        }
        if (id == R.id.acbSignOutNo) {
            NavDirections action = BottomSheetFMDirections.actionDrawerLogoutToManagementFM();
            navController.navigate(action);
        }
    }


}
