package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private EntityManager em;

    //상품 저장
    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    //상품 하나 조회
    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    //상품 전체 조회
    public List<Item> findAll(){
       return em.createQuery("select i from  Item  i", Item.class).getResultList();
    }
}
