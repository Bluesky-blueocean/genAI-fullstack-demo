// src/services/ProductService.js

import axios from 'axios';

const API_URL = "http://localhost:8080/api/products";

class ProductService {
    getAllProducts() {
        return axios.get(API_URL);
    }

    addProduct(name, price) {
        return axios.post(`${API_URL}/add`, null, {
            params: { name: name, price: price }
        });
    }

    deleteProduct(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
}

export default new ProductService();