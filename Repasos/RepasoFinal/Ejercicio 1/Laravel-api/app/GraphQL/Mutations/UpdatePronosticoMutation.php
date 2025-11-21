<?php

declare(strict_types=1);

namespace App\GraphQL\Mutations;

use App\Models\Pronostico;
use Closure;
use GraphQL\Type\Definition\ResolveInfo;
use GraphQL\Type\Definition\Type;
use Rebing\GraphQL\Support\Facades\GraphQL;
use Rebing\GraphQL\Support\Mutation;
use Rebing\GraphQL\Support\SelectFields;

class UpdatePronosticoMutation extends Mutation
{
    protected $attributes = [
        'name' => 'updatePronostico',
        'description' => 'A mutation'
    ];

    public function type(): Type
    {
        return GraphQL::type('Pronostico');
    }

    public function args(): array
    {
        return [
            'id' => [
                'name' => 'id',
                'type' => Type::nonNull(Type::int()),
            ],
            'fecha' => [
                'name' => 'fecha',
                'type' => Type::string(),
            ],
            'cantidad_estimada' => [
                'name' => 'cantidad_estimada',
                'type' => Type::int(),
            ],
        ];
    }

    public function resolve($root, array $args, $context, ResolveInfo $resolveInfo, Closure $getSelectFields)
    {
        $fields = $getSelectFields();
        $select = $fields->getSelect();
        $with = $fields->getRelations();

        $pronostico = Pronostico::findOrFail($args['id']);
        if (isset($args['fecha'])) {
            $pronostico->fecha = $args['fecha'];
        }
        if (isset($args['cantidad_estimada'])) {
            $pronostico->cantidad_estimada = $args['cantidad_estimada'];
        }
        
        $pronostico->save();
        return $pronostico;
    }
}
