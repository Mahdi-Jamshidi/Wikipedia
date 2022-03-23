package ir.magiccodes.wikipedia.fragment


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.magiccodes.wikipedia.data.ProfileInformation
import ir.magiccodes.wikipedia.databinding.DialogChangeProfileBinding
import ir.magiccodes.wikipedia.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = ProfileInformation("developer","+91-8129999999" , "developer@appsnipp.com" , "Avenue 2nd Street NW SY." , "12-05-1990")

        binding.txtNameMain.text = data.Name
        binding.txtEmailMain.text = data.Email
        binding.tvName.text = data.Name
        binding.tvMobile.text = data.Mobile_number
        binding.tvEmail.text = data.Email
        binding.tvAddress.text = data.Address
        binding.tvDob.text = data.DOB

        binding.btnChangeProfile.setOnClickListener {

            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogChangeProfileBinding = DialogChangeProfileBinding.inflate(layoutInflater)
            dialog.setView(dialogChangeProfileBinding.root)
            dialog.setCancelable(true)
            dialog.show()

            dialogChangeProfileBinding.dialogEdtName.setText(data.Name)
            dialogChangeProfileBinding.dialogEdtMobile.setText(data.Mobile_number)
            dialogChangeProfileBinding.dialogEdtEmail.setText(data.Email)
            dialogChangeProfileBinding.dialogEdtAddress.setText(data.Address)
            dialogChangeProfileBinding.dialogEdtDob.setText(data.DOB)

            dialogChangeProfileBinding.dialogUpdateBtnCancel.setOnClickListener {
                dialog.dismiss()
            }

            dialogChangeProfileBinding.dialogUpdateBtnDone.setOnClickListener {
                if (
                    dialogChangeProfileBinding.dialogEdtName.length() > 0 &&
                    dialogChangeProfileBinding.dialogEdtMobile.length() > 0 &&
                    dialogChangeProfileBinding.dialogEdtEmail.length() > 0 &&
                    dialogChangeProfileBinding.dialogEdtAddress.length() > 0 &&
                    dialogChangeProfileBinding.dialogEdtDob.length() > 0
                ){

                    val txtName = dialogChangeProfileBinding.dialogEdtName.text.toString()
                    val txtMobile = dialogChangeProfileBinding.dialogEdtMobile.text.toString()
                    val txtEmail = dialogChangeProfileBinding.dialogEdtEmail.text.toString()
                    val txtAddress = dialogChangeProfileBinding.dialogEdtAddress.text.toString()
                    val txtDOB = dialogChangeProfileBinding.dialogEdtDob.text.toString()

                    val newProfile = ProfileInformation(txtName,txtMobile,txtEmail,txtAddress,txtDOB)

                    binding.txtNameMain.text = newProfile.Name
                    binding.txtEmailMain.text = newProfile.Email
                    binding.tvName.text = newProfile.Name
                    binding.tvMobile.text = newProfile.Mobile_number
                    binding.tvEmail.text = newProfile.Email
                    binding.tvAddress.text = newProfile.Address
                    binding.tvDob.text = newProfile.DOB

                    dialog.dismiss()

                }else{
                    Toast.makeText(requireContext(), "Please enter all values", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}