package com.cw.pinki.brand.dao.impl;

import com.cw.pinki.brand.dao.ProdTypeDao;
import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabel;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ProdTypeDaoImpl implements ProdTypeDao {
    @PersistenceContext
    private Session session;

    public Session getSession() {
        return this.session;
    }

    @Override
    public ProdCategory insertProdCategory(ProdCategory prodCategory) {
        if(prodCategory != null && prodCategory.getProdCategoryNo() == null){
            this.getSession().persist(prodCategory);
            return prodCategory;
        }
        return null;
    }

    @Override
    public ProdCategory updateProdCategory(ProdCategory prodCategory) {
        if(prodCategory != null && prodCategory.getProdCategoryNo() != null){
            ProdCategory vo = this.getSession().get(ProdCategory.class, prodCategory.getProdCategoryNo());
            if(vo != null){
                return this.getSession().merge(vo);
            }
        }
        return null;
    }

    @Override
    public boolean deleteProdCategory(Integer prodCategoryNo) {
        if(prodCategoryNo != null){
            ProdCategory vo = this.getSession().get(ProdCategory.class, prodCategoryNo);
            if(vo != null){
                this.getSession().remove(vo);
                return true;
            }
        }
        return false;
    }

    @Override
    public ProdLabel insertProdLabel(ProdLabel prodLabel) {
        if(prodLabel != null && prodLabel.getProdLabelNo() == null){
            this.getSession().persist(prodLabel);
            return prodLabel;
        }
        return null;
    }

    @Override
    public ProdLabel updateProdLabel(ProdLabel prodLabel) {
        if(prodLabel != null && prodLabel.getProdLabelNo()!=null){
            ProdLabel vo = this.getSession().get(ProdLabel.class, prodLabel.getProdLabelNo());
            if(vo != null){
                this.getSession().merge(vo);
            }
        }
        return null;
    }

    @Override
    public boolean deleteProdLabel(Integer prodLabelNo) {
        if(prodLabelNo != null){
            ProdLabel vo = this.getSession().get(ProdLabel.class, prodLabelNo);
            if(vo != null){
                this.getSession().remove(vo);
                return true;
            }
        }
        return false;
    }
}
