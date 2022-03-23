//package com.example.namstyling20.ui.recommendation;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.example.namstyling20.databinding.FragmentRecommendationBinding;
//
//public class RecommendationFragment extends Fragment {
//
//    private FragmentRecommendationBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        com.example.namstyling20.ui.recommendation.RecommendationViewModel recommendationViewModel =
//                new ViewModelProvider(this).get(com.example.namstyling20.ui.recommendation.RecommendationViewModel.class);
//
//        binding = FragmentRecommendationBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textDashboard;
//        recommendationViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//}