<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});
Route::get('/playground', function () {
    return view('graphql-playground::index');
});