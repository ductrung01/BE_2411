package vn.com.t3h.claim_manager.service.DTO;

import java.time.LocalDate;

public class ClaimDetailDTO {
        private String code;
        private String nameCustomer;
        private String email;
        private String phoneNumber;
        private String nameInsuranceProduct;
        private LocalDate claimDate;
        private String description;
        private String status;

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getNameCustomer() {
                return nameCustomer;
        }

        public void setNameCustomer(String nameCustomer) {
                this.nameCustomer = nameCustomer;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getNameInsuranceProduct() {
                return nameInsuranceProduct;
        }

        public void setNameInsuranceProduct(String nameInsuranceProduct) {
                this.nameInsuranceProduct = nameInsuranceProduct;
        }

        public LocalDate getclaimDate() {
                return claimDate;
        }

        public void setclaimDate(LocalDate claimDate) {
                this.claimDate = claimDate;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
