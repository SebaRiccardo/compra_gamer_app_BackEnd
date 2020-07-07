package compragamerapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import compragamerapp.entities.ItemToPurchase;
import compragamerapp.repository.ItemToPurchaseRepository;


@Service
public class ItemTopurchaseService {
        @Autowired
        ItemToPurchaseRepository ITPRepository;

        public List<ItemToPurchase> getAll() {
            return ITPRepository.findAll();
        }
        public ItemToPurchase getItem(Long id){
            return ITPRepository.findById(id).orElse(null);
        }
        public ItemToPurchase saveItem (ItemToPurchase item){
            return ITPRepository.save(item);
        }
        public void deleteItem(Long id){
            ITPRepository.deleteById(id);
        }
        public List<ItemToPurchase> saveAll(List<ItemToPurchase>items){
            return ITPRepository.saveAll(items);
        }

}