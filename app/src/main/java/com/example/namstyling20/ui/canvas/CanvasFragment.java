package com.example.namstyling20.ui.canvas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.namstyling20.databinding.FragmentCanvasBinding;

public class CanvasFragment extends Fragment {

    private FragmentCanvasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.namstyling20.ui.canvas.CanvasViewModel recommendationViewModel =
                new ViewModelProvider(this).get(com.example.namstyling20.ui.canvas.CanvasViewModel.class);

        binding = FragmentCanvasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCanvas;
//        recommendationViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}