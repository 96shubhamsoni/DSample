package com.example.dsample.model;

import com.google.gson.annotations.SerializedName;

public class Grocery {
        @SerializedName("id")
        public String id;

        @SerializedName("title")
        public String title;

        @SerializedName("quantity")
        public String quantity;

        @SerializedName("image_url")
        public String imageUrl;

        @SerializedName("original_price")
        public String original_price;

        @SerializedName("offer_price")
        public String offer_price;

        @SerializedName("discount_percentage")
        public String discount_percentage;

}
