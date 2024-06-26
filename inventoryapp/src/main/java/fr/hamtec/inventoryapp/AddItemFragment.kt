package fr.hamtec.inventoryapp

import android.app.Fragment
import fr.hamtec.inventoryapp.data.Item

class AddItemFragment: Fragment() {

//    private val navigationArgs: ItemDetailFragmentArgs by navArgs()
    lateinit var item: Item

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    // to share the ViewModel across fragments.
//    private val viewModel: InventoryViewModel by activityViewModels {
//        InventoryViewModelFactory(
//            (activity?.application as InventoryApplication).database.itemDao()
//        )
//    }

    // Binding object instance corresponding to the fragment_add_item.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment
//    private var _binding: FragmentAddItemBinding? = null
//    private val binding get() = _binding!!

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
//        return binding.root
//    }

    /**
     * Returns true if the EditTexts are not empty
     */
//    private fun isEntryValid(): Boolean {
//        return viewModel.isEntryValid(
//            binding.itemName.text.toString(),
//            binding.itemPrice.text.toString(),
//            binding.itemCount.text.toString(),
//        )
//    }

    /**
     * Inserts the new Item into database and navigates up to list fragment.
     */
//    private fun addNewItem() {
//        if (isEntryValid()) {
//            viewModel.addNewItem(
//                binding.itemName.text.toString(),
//                binding.itemPrice.text.toString(),
//                binding.itemCount.text.toString(),
//            )
//            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
//            findNavController().navigate(action)
//        }
//    }

    /**
     * Called when the view is created.
     * The itemId Navigation argument determines the edit item  or add new item.
     * If the itemId is positive, this method retrieves the information from the database and
     * allows the user to update it.
     */
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.saveAction.setOnClickListener {
//            addNewItem()
//        }
//    }

    /**
     * Called before fragment is destroyed.
     */
//    override fun onDestroyView() {
//        super.onDestroyView()
//        // Hide keyboard.
//        val inputMethodManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as
//                InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
//        _binding = null
//    }
}