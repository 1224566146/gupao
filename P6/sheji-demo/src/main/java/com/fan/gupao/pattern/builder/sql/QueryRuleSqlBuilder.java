package com.fan.gupao.pattern.builder.sql;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 根据QueryRule自动构建sql语句
 * @Author: 樊高风
 * @Date: 15:16 2020/5/19
 */
public class QueryRuleSqlBuilder {

    // 记录参数所在的位置
    private int CURR_INDEX = 0;
    // 保存列名列表
    private List<String> properties;
    // 保存参数值列表
    private List<Object> values;
    // 保存排序规则列表
    private List<Order> orders;

    private String whereSql = "";
    private String orderSql = "";
    private Object[] valueArr = new Object[]{};
    private Map<Object, Object> valueMap = new HashMap<>();


    private String getWhereSql() {
        return this.whereSql;
    }

    private String getOrderSql() {
        return this.orderSql;
    }

    public Object[] getValues() {
        return this.valueArr;
    }

    private Map<Object, Object> getValueMap() {
        return this.valueMap;
    }

    /**
     * 功能描述：创建SQL构造器
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:28
     * @param:
     * @return:
     */
    public QueryRuleSqlBuilder(QueryRule queryRule) {
        CURR_INDEX = 0;
        properties = new ArrayList<>();
        values = new ArrayList<>();
        orders = new ArrayList<>();
        for (QueryRule.Rule rule : queryRule.getRuleList()) {
            switch (rule.getType()) {
                case QueryRule.BETWEEN:
                    processBetWeen(rule);
                    break;
                case QueryRule.EQ:
                    processEqual(rule);
                    break;
                case QueryRule.LIKE:
                    processLike(rule);
                    break;
                case QueryRule.NOTEQ:
                    processNotEqual(rule);
                    break;
                case QueryRule.GT:
                    processGreaterThen(rule);
                    break;
                case QueryRule.GE:
                    processGreaterEqual(rule);
                    break;
                case QueryRule.LT:
                    processLessThen(rule);
                    break;
                case QueryRule.LE:
                    processLessEqual(rule);
                    break;
                case QueryRule.IN:
                    processIN(rule);
                    break;
                case QueryRule.NOTIN:
                    processNotIn(rule);
                    break;
                case QueryRule.ISNULL:
                    processIsNull(rule);
                    break;
                case QueryRule.ISNOTNULL:
                    processIsNotNull(rule);
                    break;
                case QueryRule.ISEMPTY:
                    processIsEmpty(rule);
                    break;
                case QueryRule.ISNOTEMPTY:
                    processIsNotEmpty(rule);
                    break;
                case QueryRule.ASC_ORDER:
                    processOrder(rule);
                    break;
                case QueryRule.DESC_ORDER:
                    processOrder(rule);
                    break;
                default:
                    throw new IllegalArgumentException("type " + rule.getType() + " not supported.");

            }
        }

        // 拼装where语句
        appendWhereSql();
        // 拼装排序语句
        appendOrderSql();
        // 拼装参数值
        appendValues();

    }

    /**
     * 功能描述：去掉order
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:31
     * @param:
     * @return:
     */
    private String removeOrders(String sql) {
        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(sql);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 功能描述：去掉select
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:33
     * @param:
     * @return:
     */
    private String removeSelect(String sql) {
        if (sql.toLowerCase().matches("from\\s+")) {
            int beginPos = sql.toLowerCase().indexOf("from");
            return sql.substring(beginPos);
        } else {
            return sql;
        }
    }

    /**
     * 功能描述：处理like
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:36
     * @param:
     * @return:
     */
    private void processLike(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        Object obj = rule.getValues()[0];

        if (obj != null) {
            String value = obj.toString();
            if (!StringUtils.isEmpty(value)) {
                value = value.replace('*', '%');
                obj = value;
            }
        }
        add(rule.getAndOr(), rule.getPropertyName(), "like", "%" + rule.getValues()[0] + "%");
    }

    /**
     * 功能描述：处理between
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:39
     * @param:
     * @return:
     */
    private void processBetWeen(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())
                || (rule.getValues().length < 2)) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), "", "between", rule.getValues()[0], "and");
        add(0, "", "", "", rule.getValues()[1], "");
    }

    /**
     * 功能描述：处理 =
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:48
     * @param:
     * @return:
     */
    private void processEqual(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), "=", rule.getValues()[0]);
    }

    /**
     * 功能描述：处理<>
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:49
     * @param:
     * @return:
     */
    private void processNotEqual(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), "<>", rule.getValues()[0]);
    }

    /**
     * 功能描述：处理 >
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processGreaterThen(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), ">", rule.getValues()[0]);
    }


    /**
     * 功能描述：处理>=
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processGreaterEqual(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), ">=", rule.getValues()[0]);
    }

    /**
     * 功能描述：处理<
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processLessThen(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), "<", rule.getValues()[0]);
    }

    /**
     * 功能描述：处理<=
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processLessEqual(QueryRule.Rule rule) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        add(rule.getAndOr(), rule.getPropertyName(), "<=", rule.getValues()[0]);
    }

    /**
     * 功能描述：加入到sql查询规则队列
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:40
     * @param:
     * @return:
     */
    private void add(int andOr, String key, String split, Object value) {
        add(andOr, key, split, "", value, "");
    }

    /**
     * 功能描述：处理 is null
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processIsNull(QueryRule.Rule rule) {
        add(rule.getAndOr(), rule.getPropertyName(), "is null", null);
    }

    /**
     * 功能描述：处理 is not null
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processIsNotNull(QueryRule.Rule rule) {
        add(rule.getAndOr(), rule.getPropertyName(), "is not null", null);
    }

    /**
     * 功能描述：处理 <>''
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processIsNotEmpty(QueryRule.Rule rule) {
        add(rule.getAndOr(), rule.getPropertyName(), "<>", "''");
    }

    /**
     * 功能描述：处理 =''
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 15:51
     * @param:
     * @return:
     */
    private void processIsEmpty(QueryRule.Rule rule) {
        add(rule.getAndOr(), rule.getPropertyName(), "=", "''");
    }

    /**
     * 功能描述：处理in和not in
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:04
     * @param:
     * @return:
     */
    private void inAndNotIn(QueryRule.Rule rule, String name) {
        if (ArrayUtils.isEmpty(rule.getValues())) {
            return;
        }
        if ((rule.getValues().length == 1) && (rule.getValues()[0] != null
                && (rule.getValues()[0] instanceof List))) {
            List<Object> list = (List) rule.getValues()[0];

            if ((list != null) && (list.size() > 0)) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0 && i == list.size() - 1) {
                        add(rule.getAndOr(), rule.getPropertyName(), "", name + " (", list.get(i), ")");
                    } else if (i == 0 && i < list.size() - 1) {
                        add(rule.getAndOr(), rule.getPropertyName(), "", name + " (", list.get(i), "");

                    }
                    if (i > 0 && i < list.size() - 1) {
                        add(0, "", ",", "", list.get(i), "");
                    }
                    if (i == list.size() - 1 && i != 0) {
                        add(0, "", ",", "", list.get(i), ")");
                    }
                }
            }
        } else {
            Object[] list = rule.getValues();
            for (int i = 0; i < list.length; i++) {
                if (i == 0 && i == list.length - 1) {
                    add(rule.getAndOr(), rule.getPropertyName(), "", name + " (", list[i], ")");
                } else if (i == 0 && i < list.length - 1) {
                    add(rule.getAndOr(), rule.getPropertyName(), "", name + " (", list[i], "");

                }
                if (i > 0 && i < list.length - 1) {
                    add(0, "", ",", "", list[i], "");
                }
                if (i == list.length - 1 && i != 0) {
                    add(0, "", ",", "", list[i], ")");
                }
            }
        }
    }

    /**
     * 功能描述：处理not in
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:05
     * @param:
     * @return:
     */
    private void processNotIn(QueryRule.Rule rule) {
        inAndNotIn(rule, "not in");
    }

    /**
     * 功能描述：处理 in
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:05
     * @param:
     * @return:
     */
    private void processIN(QueryRule.Rule rule) {
        inAndNotIn(rule, "in");
    }

    /**
     * 功能描述：处理order by
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:06
     * @param:
     * @return:
     */
    private void processOrder(QueryRule.Rule rule) {
        switch (rule.getType()) {
            case QueryRule.ASC_ORDER:
                // propertyName 非空
                if (!StringUtils.isEmpty(rule.getPropertyName())) {
                    orders.add(Order.asc(rule.getPropertyName()));
                }
                break;
            case QueryRule.DESC_ORDER:
                // propertyName 非空
                if (!StringUtils.isEmpty(rule.getPropertyName())) {
                    orders.add(Order.desc(rule.getPropertyName()));
                }
                break;
            default:
                break;
        }
    }

    /**
     * 功能描述：加入到sql查询规则队列
     *
     * @param andOr  and或者 or
     * @param key    列名
     * @param split  列名与值之间的间隔
     * @param prefix 值前缀
     * @param value  值
     * @param suffix 值后缀
     * @authorer: 樊高风
     * @date: 2020/5/19 15:42
     * @return:
     */
    private void add(int andOr, String key, String split, String prefix, Object value, String suffix) {
        String andOrStr = (0 == andOr ? "" : (QueryRule.AND == andOr ? " and " : " or "));
        properties.add(CURR_INDEX, andOrStr + key + " " + split + prefix + (null != value ? " ? " : " ") + suffix);
        if (null != value) {
            values.add(CURR_INDEX, value);
            CURR_INDEX++;
        }
    }

    /**
     * 功能描述：拼装where语句
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:09
     * @param:
     * @return:
     */
    private void appendWhereSql() {
        StringBuffer whereSql = new StringBuffer();
        for (String property : properties) {
            whereSql.append(property);
        }
        this.whereSql = removeSelect(removeOrders(whereSql.toString()));
    }

    /**
     * 功能描述：拼装排序语句
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:10
     * @param:
     * @return:
     */
    private void appendOrderSql() {
        StringBuffer orderSql = new StringBuffer();
        for (int i = 0; i < orders.size(); i++) {
            if (i > 0 && i < orders.size()) {
                orderSql.append(",");
            }
            orderSql.append(orders.get(i).toString());
        }
        this.orderSql = removeSelect(removeOrders(orderSql.toString()));
    }

    /**
     * 功能描述：拼装参数值
     *
     * @authorer: 樊高风
     * @date: 2020/5/19 16:11
     * @param:
     * @return:
     */
    private void appendValues() {
        Object[] val = new Object[values.size()];
        for (int i = 0; i < values.size(); i++) {
            val[i] = values.get(i);
            valueMap.put(i, values.get(i));
        }
        this.valueArr = val;
    }

    public String builder(String tableName) {
        String ws = removeFirstAnd(this.getWhereSql());
        String whereSql = ("".equals(ws)) ? ws : (" where " + ws);
        String sql = "select * from " + tableName + whereSql;
        Object[] values = this.getValues();
        String orderSql = this.getOrderSql();
        orderSql = (StringUtils.isEmpty(orderSql) ? " " : (" order by " + orderSql));
        sql += orderSql;
        return sql;
    }

    private String removeFirstAnd(String sql) {
        if (StringUtils.isEmpty(sql)) {
            return sql;
        }
        return sql.trim().toLowerCase().replaceAll("^\\s*and", "") + " ";
    }

}
