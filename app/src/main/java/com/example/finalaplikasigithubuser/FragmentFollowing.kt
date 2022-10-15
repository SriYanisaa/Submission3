package com.example.finalaplikasigithubuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalaplikasigithubuser.databinding.FragmentFollowingBinding

class FragmentFollowing : Fragment(R.layout.fragment_following) {

    private var vbinding: FragmentFollowingBinding? = null
    private val binding get() = vbinding
    private lateinit var viewModel: FollowingViewModel
    private lateinit var adapter: ListUserAdapter
    private lateinit var user: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vbinding = FragmentFollowingBinding.bind(view)
        user = arguments?.getString(ActivityDetail.USERNAME).toString()
        adapter = ListUserAdapter()
        adapter.notifyDataSetChanged()

        binding?.apply {
            rvUsers.layoutManager = LinearLayoutManager(requireContext())
            rvUsers.setHasFixedSize(true)
            rvUsers.adapter = adapter
        }
        showLoading(true)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(FollowingViewModel::class.java)
        viewModel.setListFollowing(user)
        viewModel.getListFollowing().observe(viewLifecycleOwner){
            if (it != null){
                adapter.setList(it)
                showLoading(false)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        vbinding = null
    }

    private fun showLoading(state: Boolean){
        if (state){
            binding?.progressBarFollowing?.visibility = View.VISIBLE
        }
        else{
            binding?.progressBarFollowing?.visibility = View.GONE
        }
    }
}