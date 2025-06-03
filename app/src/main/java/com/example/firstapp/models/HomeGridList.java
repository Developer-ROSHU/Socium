package com.example.firstapp.models;

public class HomeGridList {
        private int Image;
        private String Description;

        public HomeGridList(int Image, String Description){
            this.Image = Image;
            this.Description = Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
        public void setImage(int image) {
            Image = image;
        }

        public String getDescription() {
            return Description;
        }

        public int getImage() {
            return Image;
        }
}
