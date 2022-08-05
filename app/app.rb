#!/usr/bin/ruby
require 'sinatra'

configure do
  set :bind, '0.0.0.0'
  set :port, '8080'
end

get '/' do
  'Hello world from Neoflex!'
end
