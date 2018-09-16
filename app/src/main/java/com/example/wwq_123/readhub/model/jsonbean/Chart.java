package com.example.wwq_123.readhub.model.jsonbean;

import java.util.List;

public class Chart {

    /**
     * salary : {"data":[{"xaxis":"5","yaxis":8},{"xaxis":"6","yaxis":9},{"xaxis":"7","yaxis":8},{"xaxis":"8","yaxis":14},{"xaxis":"9","yaxis":14},{"xaxis":"10","yaxis":21},{"xaxis":"11","yaxis":17},{"xaxis":"12","yaxis":18},{"xaxis":"13","yaxis":13},{"xaxis":"14","yaxis":13}],"unit":"k"}
     * experience : {"data":[{"xaxis":"1","yaxis":18},{"xaxis":"2","yaxis":14},{"xaxis":"3","yaxis":26},{"xaxis":"4","yaxis":12},{"xaxis":"5","yaxis":12}],"unit":"年"}
     * city : {"data":[{"xaxis":"北京","yaxis":13},{"xaxis":"上海","yaxis":5},{"xaxis":"广州","yaxis":5},{"xaxis":"杭州","yaxis":3},{"xaxis":"成都","yaxis":2},{"xaxis":"天津","yaxis":2},{"xaxis":"石家庄","yaxis":2},{"xaxis":"苏州","yaxis":1},{"xaxis":"南京","yaxis":1},{"xaxis":"合肥","yaxis":1}],"unit":""}
     */

    private SalaryBean salary;
    private ExperienceBean experience;
    private CityBean city;

    public SalaryBean getSalary() {
        return salary;
    }

    public void setSalary(SalaryBean salary) {
        this.salary = salary;
    }

    public ExperienceBean getExperience() {
        return experience;
    }

    public void setExperience(ExperienceBean experience) {
        this.experience = experience;
    }

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public static class SalaryBean {
        /**
         * data : [{"xaxis":"5","yaxis":8},{"xaxis":"6","yaxis":9},{"xaxis":"7","yaxis":8},{"xaxis":"8","yaxis":14},{"xaxis":"9","yaxis":14},{"xaxis":"10","yaxis":21},{"xaxis":"11","yaxis":17},{"xaxis":"12","yaxis":18},{"xaxis":"13","yaxis":13},{"xaxis":"14","yaxis":13}]
         * unit : k
         */

        private String unit;
        private List<DataBean> data;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * xaxis : 5
             * yaxis : 8
             */

            private String xaxis;
            private int yaxis;

            public String getXaxis() {
                return xaxis;
            }

            public void setXaxis(String xaxis) {
                this.xaxis = xaxis;
            }

            public int getYaxis() {
                return yaxis;
            }

            public void setYaxis(int yaxis) {
                this.yaxis = yaxis;
            }
        }
    }

    public static class ExperienceBean {
        /**
         * data : [{"xaxis":"1","yaxis":18},{"xaxis":"2","yaxis":14},{"xaxis":"3","yaxis":26},{"xaxis":"4","yaxis":12},{"xaxis":"5","yaxis":12}]
         * unit : 年
         */

        private String unit;
        private List<DataBeanX> data;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public static class DataBeanX {
            /**
             * xaxis : 1
             * yaxis : 18
             */

            private String xaxis;
            private int yaxis;

            public String getXaxis() {
                return xaxis;
            }

            public void setXaxis(String xaxis) {
                this.xaxis = xaxis;
            }

            public int getYaxis() {
                return yaxis;
            }

            public void setYaxis(int yaxis) {
                this.yaxis = yaxis;
            }
        }
    }

    public static class CityBean {
        /**
         * data : [{"xaxis":"北京","yaxis":13},{"xaxis":"上海","yaxis":5},{"xaxis":"广州","yaxis":5},{"xaxis":"杭州","yaxis":3},{"xaxis":"成都","yaxis":2},{"xaxis":"天津","yaxis":2},{"xaxis":"石家庄","yaxis":2},{"xaxis":"苏州","yaxis":1},{"xaxis":"南京","yaxis":1},{"xaxis":"合肥","yaxis":1}]
         * unit :
         */

        private String unit;
        private List<DataBeanXX> data;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public List<DataBeanXX> getData() {
            return data;
        }

        public void setData(List<DataBeanXX> data) {
            this.data = data;
        }

        public static class DataBeanXX {
            /**
             * xaxis : 北京
             * yaxis : 13
             */

            private String xaxis;
            private int yaxis;

            public String getXaxis() {
                return xaxis;
            }

            public void setXaxis(String xaxis) {
                this.xaxis = xaxis;
            }

            public int getYaxis() {
                return yaxis;
            }

            public void setYaxis(int yaxis) {
                this.yaxis = yaxis;
            }
        }
    }
}
