package cn.ccf.pojo;

import java.util.ArrayList;
import java.util.List;

public class YZTCameraExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YZTCameraExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLayeridIsNull() {
            addCriterion("LayerID is null");
            return (Criteria) this;
        }

        public Criteria andLayeridIsNotNull() {
            addCriterion("LayerID is not null");
            return (Criteria) this;
        }

        public Criteria andLayeridEqualTo(Integer value) {
            addCriterion("LayerID =", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridNotEqualTo(Integer value) {
            addCriterion("LayerID <>", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridGreaterThan(Integer value) {
            addCriterion("LayerID >", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("LayerID >=", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridLessThan(Integer value) {
            addCriterion("LayerID <", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridLessThanOrEqualTo(Integer value) {
            addCriterion("LayerID <=", value, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridIn(List<Integer> values) {
            addCriterion("LayerID in", values, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridNotIn(List<Integer> values) {
            addCriterion("LayerID not in", values, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridBetween(Integer value1, Integer value2) {
            addCriterion("LayerID between", value1, value2, "layerid");
            return (Criteria) this;
        }

        public Criteria andLayeridNotBetween(Integer value1, Integer value2) {
            addCriterion("LayerID not between", value1, value2, "layerid");
            return (Criteria) this;
        }

        public Criteria andDomainidIsNull() {
            addCriterion("DomainID is null");
            return (Criteria) this;
        }

        public Criteria andDomainidIsNotNull() {
            addCriterion("DomainID is not null");
            return (Criteria) this;
        }

        public Criteria andDomainidEqualTo(String value) {
            addCriterion("DomainID =", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidNotEqualTo(String value) {
            addCriterion("DomainID <>", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidGreaterThan(String value) {
            addCriterion("DomainID >", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidGreaterThanOrEqualTo(String value) {
            addCriterion("DomainID >=", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidLessThan(String value) {
            addCriterion("DomainID <", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidLessThanOrEqualTo(String value) {
            addCriterion("DomainID <=", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidLike(String value) {
            addCriterion("DomainID like", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidNotLike(String value) {
            addCriterion("DomainID not like", value, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidIn(List<String> values) {
            addCriterion("DomainID in", values, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidNotIn(List<String> values) {
            addCriterion("DomainID not in", values, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidBetween(String value1, String value2) {
            addCriterion("DomainID between", value1, value2, "domainid");
            return (Criteria) this;
        }

        public Criteria andDomainidNotBetween(String value1, String value2) {
            addCriterion("DomainID not between", value1, value2, "domainid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("Latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("Latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("Latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("Latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("Latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("Latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("Latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("Latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("Latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("Latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("Latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("Latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("Longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("Longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("Longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("Longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("Longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("Longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("Longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("Longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("Longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("Longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("Longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("Longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("Address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("Address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPlayurlIsNull() {
            addCriterion("PlayUrl is null");
            return (Criteria) this;
        }

        public Criteria andPlayurlIsNotNull() {
            addCriterion("PlayUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPlayurlEqualTo(String value) {
            addCriterion("PlayUrl =", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlNotEqualTo(String value) {
            addCriterion("PlayUrl <>", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlGreaterThan(String value) {
            addCriterion("PlayUrl >", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlGreaterThanOrEqualTo(String value) {
            addCriterion("PlayUrl >=", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlLessThan(String value) {
            addCriterion("PlayUrl <", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlLessThanOrEqualTo(String value) {
            addCriterion("PlayUrl <=", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlLike(String value) {
            addCriterion("PlayUrl like", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlNotLike(String value) {
            addCriterion("PlayUrl not like", value, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlIn(List<String> values) {
            addCriterion("PlayUrl in", values, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlNotIn(List<String> values) {
            addCriterion("PlayUrl not in", values, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlBetween(String value1, String value2) {
            addCriterion("PlayUrl between", value1, value2, "playurl");
            return (Criteria) this;
        }

        public Criteria andPlayurlNotBetween(String value1, String value2) {
            addCriterion("PlayUrl not between", value1, value2, "playurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlIsNull() {
            addCriterion("PtzUrl is null");
            return (Criteria) this;
        }

        public Criteria andPtzurlIsNotNull() {
            addCriterion("PtzUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPtzurlEqualTo(String value) {
            addCriterion("PtzUrl =", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlNotEqualTo(String value) {
            addCriterion("PtzUrl <>", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlGreaterThan(String value) {
            addCriterion("PtzUrl >", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlGreaterThanOrEqualTo(String value) {
            addCriterion("PtzUrl >=", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlLessThan(String value) {
            addCriterion("PtzUrl <", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlLessThanOrEqualTo(String value) {
            addCriterion("PtzUrl <=", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlLike(String value) {
            addCriterion("PtzUrl like", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlNotLike(String value) {
            addCriterion("PtzUrl not like", value, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlIn(List<String> values) {
            addCriterion("PtzUrl in", values, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlNotIn(List<String> values) {
            addCriterion("PtzUrl not in", values, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlBetween(String value1, String value2) {
            addCriterion("PtzUrl between", value1, value2, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andPtzurlNotBetween(String value1, String value2) {
            addCriterion("PtzUrl not between", value1, value2, "ptzurl");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNull() {
            addCriterion("FinishTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNotNull() {
            addCriterion("FinishTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeEqualTo(String value) {
            addCriterion("FinishTime =", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotEqualTo(String value) {
            addCriterion("FinishTime <>", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThan(String value) {
            addCriterion("FinishTime >", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("FinishTime >=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThan(String value) {
            addCriterion("FinishTime <", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThanOrEqualTo(String value) {
            addCriterion("FinishTime <=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLike(String value) {
            addCriterion("FinishTime like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotLike(String value) {
            addCriterion("FinishTime not like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIn(List<String> values) {
            addCriterion("FinishTime in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotIn(List<String> values) {
            addCriterion("FinishTime not in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeBetween(String value1, String value2) {
            addCriterion("FinishTime between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotBetween(String value1, String value2) {
            addCriterion("FinishTime not between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andUserunitIsNull() {
            addCriterion("UserUnit is null");
            return (Criteria) this;
        }

        public Criteria andUserunitIsNotNull() {
            addCriterion("UserUnit is not null");
            return (Criteria) this;
        }

        public Criteria andUserunitEqualTo(String value) {
            addCriterion("UserUnit =", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitNotEqualTo(String value) {
            addCriterion("UserUnit <>", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitGreaterThan(String value) {
            addCriterion("UserUnit >", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitGreaterThanOrEqualTo(String value) {
            addCriterion("UserUnit >=", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitLessThan(String value) {
            addCriterion("UserUnit <", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitLessThanOrEqualTo(String value) {
            addCriterion("UserUnit <=", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitLike(String value) {
            addCriterion("UserUnit like", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitNotLike(String value) {
            addCriterion("UserUnit not like", value, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitIn(List<String> values) {
            addCriterion("UserUnit in", values, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitNotIn(List<String> values) {
            addCriterion("UserUnit not in", values, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitBetween(String value1, String value2) {
            addCriterion("UserUnit between", value1, value2, "userunit");
            return (Criteria) this;
        }

        public Criteria andUserunitNotBetween(String value1, String value2) {
            addCriterion("UserUnit not between", value1, value2, "userunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitIsNull() {
            addCriterion("ManagerUnit is null");
            return (Criteria) this;
        }

        public Criteria andManagerunitIsNotNull() {
            addCriterion("ManagerUnit is not null");
            return (Criteria) this;
        }

        public Criteria andManagerunitEqualTo(String value) {
            addCriterion("ManagerUnit =", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitNotEqualTo(String value) {
            addCriterion("ManagerUnit <>", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitGreaterThan(String value) {
            addCriterion("ManagerUnit >", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitGreaterThanOrEqualTo(String value) {
            addCriterion("ManagerUnit >=", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitLessThan(String value) {
            addCriterion("ManagerUnit <", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitLessThanOrEqualTo(String value) {
            addCriterion("ManagerUnit <=", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitLike(String value) {
            addCriterion("ManagerUnit like", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitNotLike(String value) {
            addCriterion("ManagerUnit not like", value, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitIn(List<String> values) {
            addCriterion("ManagerUnit in", values, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitNotIn(List<String> values) {
            addCriterion("ManagerUnit not in", values, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitBetween(String value1, String value2) {
            addCriterion("ManagerUnit between", value1, value2, "managerunit");
            return (Criteria) this;
        }

        public Criteria andManagerunitNotBetween(String value1, String value2) {
            addCriterion("ManagerUnit not between", value1, value2, "managerunit");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNull() {
            addCriterion("ResourceId is null");
            return (Criteria) this;
        }

        public Criteria andResourceidIsNotNull() {
            addCriterion("ResourceId is not null");
            return (Criteria) this;
        }

        public Criteria andResourceidEqualTo(String value) {
            addCriterion("ResourceId =", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotEqualTo(String value) {
            addCriterion("ResourceId <>", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThan(String value) {
            addCriterion("ResourceId >", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidGreaterThanOrEqualTo(String value) {
            addCriterion("ResourceId >=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThan(String value) {
            addCriterion("ResourceId <", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLessThanOrEqualTo(String value) {
            addCriterion("ResourceId <=", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidLike(String value) {
            addCriterion("ResourceId like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotLike(String value) {
            addCriterion("ResourceId not like", value, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidIn(List<String> values) {
            addCriterion("ResourceId in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotIn(List<String> values) {
            addCriterion("ResourceId not in", values, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidBetween(String value1, String value2) {
            addCriterion("ResourceId between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andResourceidNotBetween(String value1, String value2) {
            addCriterion("ResourceId not between", value1, value2, "resourceid");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNull() {
            addCriterion("ObjType is null");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNotNull() {
            addCriterion("ObjType is not null");
            return (Criteria) this;
        }

        public Criteria andObjtypeEqualTo(Integer value) {
            addCriterion("ObjType =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Integer value) {
            addCriterion("ObjType <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Integer value) {
            addCriterion("ObjType >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ObjType >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Integer value) {
            addCriterion("ObjType <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ObjType <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Integer> values) {
            addCriterion("ObjType in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Integer> values) {
            addCriterion("ObjType not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Integer value1, Integer value2) {
            addCriterion("ObjType between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ObjType not between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andStatustimeIsNull() {
            addCriterion("StatusTime is null");
            return (Criteria) this;
        }

        public Criteria andStatustimeIsNotNull() {
            addCriterion("StatusTime is not null");
            return (Criteria) this;
        }

        public Criteria andStatustimeEqualTo(String value) {
            addCriterion("StatusTime =", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeNotEqualTo(String value) {
            addCriterion("StatusTime <>", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeGreaterThan(String value) {
            addCriterion("StatusTime >", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeGreaterThanOrEqualTo(String value) {
            addCriterion("StatusTime >=", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeLessThan(String value) {
            addCriterion("StatusTime <", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeLessThanOrEqualTo(String value) {
            addCriterion("StatusTime <=", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeLike(String value) {
            addCriterion("StatusTime like", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeNotLike(String value) {
            addCriterion("StatusTime not like", value, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeIn(List<String> values) {
            addCriterion("StatusTime in", values, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeNotIn(List<String> values) {
            addCriterion("StatusTime not in", values, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeBetween(String value1, String value2) {
            addCriterion("StatusTime between", value1, value2, "statustime");
            return (Criteria) this;
        }

        public Criteria andStatustimeNotBetween(String value1, String value2) {
            addCriterion("StatusTime not between", value1, value2, "statustime");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("Hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("Hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("Hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("Hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("Hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("Hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("Hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("Hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("Hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("Hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("Hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("Hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}