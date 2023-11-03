package com.cw.pinki.brand.dao.impl;

import com.cw.pinki.brand.dao.ProdTypeDao;
import com.cw.pinki.common.vo.ProdCategory;
import com.cw.pinki.common.vo.ProdLabel;
import com.cw.pinki.common.vo.ProdLabelConfig;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ProdTypeDaoImpl implements ProdTypeDao {
    @PersistenceContext
    private Session session;

    public Session getSession() {
        return this.session;
    }

    @Override
    public List<ProdCategory> getAllCategory() {
        CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
        CriteriaQuery<ProdCategory> criteriaQuery = criteriaBuilder.createQuery(ProdCategory.class);
        TypedQuery<ProdCategory> typedQuery = this.getSession().createQuery(criteriaQuery);
        List<ProdCategory> prodCategories = typedQuery.getResultList();
        if (prodCategories != null && !prodCategories.isEmpty()) {
            return prodCategories;
        } else {
            return null;
        }
    }

    @Override
    public int findByProdCategoryName(String prodCategoryName) {
        Query<Integer> query = getSession().createQuery("select prodCategoryNo from ProdCategory where prodCategoryName = :prodCategoryName", Integer.class);
        query.setParameter("prodCategoryName", prodCategoryName);
        Integer prodCategoryNo = query.uniqueResult();
        return Objects.requireNonNullElse(prodCategoryNo, -1);
    }

    @Override
    public void insertProdCategory(ProdCategory prodCategory) {
        if (prodCategory != null && prodCategory.getProdCategoryNo() == null) {
            this.getSession().persist(prodCategory);
        }
    }

    @Override
    public void updateProdCategory(ProdCategory prodCategory) {
        if (prodCategory != null && prodCategory.getProdCategoryNo() != null) {
            this.getSession().merge(prodCategory);
        }
    }

    @Override
    public boolean deleteProdCategory(Integer prodCategoryNo) {
        if (prodCategoryNo != null) {
            ProdCategory vo = this.getSession().get(ProdCategory.class, prodCategoryNo);
            if (vo != null) {
                this.getSession().remove(vo);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ProdLabelConfig> getAllProdLabel(Integer brandNo) {
        Query<ProdLabelConfig> query = getSession().createQuery("from ProdLabelConfig where brandNo = :brandNo", ProdLabelConfig.class);
        query.setParameter("brandNo", brandNo);
        return query.list();
    }

    @Override
    public int findByProdLabelName(String prodLabelName, Integer brandNo) {
        Query<Integer> query = getSession().createQuery("select prodLabelConfigNo from ProdLabelConfig where brandNo = :brandNo and prodLabelName = :prodLabelName", Integer.class);
        Integer prodLabelConfigNo = query.uniqueResult();
        return Objects.requireNonNullElse(prodLabelConfigNo, -1);
    }

    @Override
    public void insertProdLabel(ProdLabelConfig prodLabel) {
        if (prodLabel != null && prodLabel.getProdLabelConfigNo() == null) {
            this.getSession().persist(prodLabel);
        }
    }

    @Override
    public void updateProdLabel(ProdLabelConfig prodLabel) {
        if (prodLabel != null && prodLabel.getProdLabelConfigNo() != null) {
            this.getSession().merge(prodLabel);
        }
    }

    @Override
    public boolean deleteProdLabel(Integer prodLabelNo) {
        if (prodLabelNo != null) {
            ProdLabel vo = this.getSession().get(ProdLabel.class, prodLabelNo);
            if (vo != null) {
                this.getSession().remove(vo);
                return true;
            }
        }
        return false;
    }
}
